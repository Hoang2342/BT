package com.example.testapp1;

import android.location.Address;

public class Information {
        private Integer id;
        private String username;
        private String name;
        private String email;
        private String company;
        private Address address;
        private  int phone;

        public Integer getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

         public int getPhone() {
            return phone;
         }

         public void setPhone(int phone) {
             this.phone = phone;
         }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("\n Id:" + this.id);
            sb.append("\n Username:" + this.username);
            sb.append("\n Name:" + this.name);
            sb.append("\n Email:" + this.email);
            sb.append("\n Company:" + this.company);
            sb.append("\n Phone:" + this.phone);
            if (this.address != null) {
                sb.append("\n address:" + this.address.toString());
            }
            return sb.toString();
        }
}

