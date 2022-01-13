package com.example.testapp1;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class ReadJson {

        // Read the company.json file and convert it to a java object.
        public static Information readJSONFile(Context context) throws IOException,JSONException {

            // Read content of company.json
            String jsonText = readText(context, R.raw.events);
            JSONObject jsonRoot = new JSONObject(jsonText);

            String username= jsonRoot.getString("username");
            String name = jsonRoot.getString("name");
            String email = jsonRoot.getString("email");
            String company = jsonRoot.getString("company");
            int phone = jsonRoot.getInt("phone");
            JSONObject jsonAddress = jsonRoot.getJSONObject("address");


            Information information = new Information();
            information.setId(information.getId());
            information.setUsername(username);
            information.setName(name);
            information.setEmail(email);
            information.setCompany(company);
            information.setAddress(information.getAddress());
            information.setPhone(information.getPhone());
            return information;
        }

        private static String readText(Context context, int resId) throws IOException {
            InputStream is = context.getResources().openRawResource(resId);
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            StringBuilder sb= new StringBuilder();
            String s= null;
            while((  s = br.readLine())!=null) {
                sb.append(s);
                sb.append("\n");
                sb.append(".");
            }
            return sb.toString();
        }

}

