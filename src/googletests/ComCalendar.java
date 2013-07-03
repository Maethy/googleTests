/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googletests;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.sun.org.apache.xpath.internal.operations.Plus;

/**
 *
 * @author jsmaya
 */
public class ComCalendar {

   public get(){ 
        // Set up the HTTP transport and JSON factory
        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();

        // Set up OAuth 2.0 access of protected resources
        // using the refresh and access tokens, automatically
        // refreshing the access token when it expires
        Credential credential = new Credential.Builder(BearerToken.authorizationHeaderAccessMethod())
            .setJsonFactory(jsonFactory)
            .setTransport(httpTransport)
            .setTokenServerEncodedUrl(  tokenServerEncodedUrl)
            .setClientAuthentication(clientAuthentication)
            .setRequestInitializer(requestInitializer)
            .build();

        // Set up the main Google+ class
        Plus plus = new Plus(httpTransport, jsonFactory, credential);

        // Make a request to access your profile and display it to console
        Person profile = plus.people().get("me").execute();
        System.out.println("ID: " + profile.getId());
        System.out.println("Name: " + profile.getDisplayName());
        System.out.println("Image URL: " + profile.getImage().getUrl());
        System.out.println("Profile URL: " + profile.getUrl());
   }
}
