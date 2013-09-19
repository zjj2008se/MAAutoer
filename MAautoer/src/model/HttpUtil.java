package model;

import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import base.Crypt;

public class HttpUtil {
	private static String host;
	private static String key;
	private static DefaultHttpClient client;

	public static void init(String host, String key) {
		HttpUtil.host = host;
		HttpUtil.key = key;

		PoolingClientConnectionManager manager = new PoolingClientConnectionManager(
				SchemeRegistryFactory.createDefault());
		manager.setMaxTotal(200);
		manager.setDefaultMaxPerRoute(50);
		client = new DefaultHttpClient(manager);
		client.getParams().setParameter("http.socket.timeout",
				new Integer(13000));
		client.getParams().setParameter("http.connection.timeout",
				new Integer(13000));
		//DefaultHttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(2, true);
		//client.setHttpRequestRetryHandler(retryHandler);
	}
	
	public static String connectGet(String url, int retryCount)
	{
		try {
			HttpGet method = new HttpGet(url);
			method.setHeader("Accept", "*/*");
			method.setHeader("Accept-Language", "en-us");
			method.setHeader("User-Agent",
					"Million/1.0.1 (iPhone; iPhone5,2; 6.0.1)");

			HttpResponse response = client.execute(method);
			byte[] responseByte = EntityUtils.toByteArray(response.getEntity());
			//byte[] responseByte = EntityUtils.toByteArray(response.getEntity());
			String result = new String(responseByte);
			return result;
		} catch (ConnectTimeoutException e) {

		} catch (SocketTimeoutException e) {
			if (retryCount < 3)
			{
				System.out.println("SocketTimeoutException Retry " + retryCount);
				return connectGet(url, retryCount + 1);
			}
			else
				e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String connectPost(String url,
			ArrayList<BasicNameValuePair> params) {
		return connectPost(url, params, 0);
	}

	public static String connectPost(String url,
			ArrayList<BasicNameValuePair> params, int retryCount) {
		try {
			HttpPost method = new HttpPost(host + url);
			method.setHeader("Accept", "*/*");
			method.setHeader("Accept-Language", "en-us");
			method.setHeader("Accept-Encoding", "gzip");
			method.setHeader("User-Agent",
					"Million/1.0.1 (iPhone; iPhone5,2; 6.0.1)");
			
			Crypt.setKey(key);
			if (params != null) {
				ArrayList<BasicNameValuePair> encodedParams = new ArrayList<BasicNameValuePair>();
				for (BasicNameValuePair param : params) {
					encodedParams.add(new BasicNameValuePair(param.getName(),Crypt.encode64(param.getValue())));
				}
				method.setEntity(new UrlEncodedFormEntity(encodedParams,"UTF-8"));
			}
			HttpResponse response = client.execute(method);
			byte[] responseByte = EntityUtils.toByteArray(new GzipDecompressingEntity(response.getEntity()));
			//byte[] responseByte = EntityUtils.toByteArray(response.getEntity());
			String result = new String(Crypt.decode(responseByte));
			return result;
		} catch (ConnectTimeoutException e) {

		} catch (SocketTimeoutException e) {
			if (retryCount < 3)
			{
				System.out.println("SocketTimeoutException Retry " + retryCount);
				return connectPost(url, params, retryCount + 1);
			}
			else
				e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (EOFException e)
		{
			if (retryCount < 30)
			{
				System.out.println("EOFException Retry " + retryCount);
				return connectPost(url, params, retryCount + 1);
			}
			else
				e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}