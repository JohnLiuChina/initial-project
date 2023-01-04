package com.learning.java8.learning.designPattern.builder;

public class User {
    private String uid;
    private String name;
    private String gender;
    private Integer age;

    private User(Builder builder) {
        uid = builder.uid;
        name = builder.name;
        gender = builder.gender;
        age = builder.age;
    }

    public static Builder Builder() {
        return new Builder();
    }

    public static class Builder{
        private String uid;
        private String name;
        private String gender;
        private Integer age;

        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
