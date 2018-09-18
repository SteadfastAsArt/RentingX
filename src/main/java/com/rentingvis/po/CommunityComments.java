package com.rentingvis.po;

public class CommunityComments {
    private String name;

    private String ques;

    private String ans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques == null ? null : ques.trim();
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans == null ? null : ans.trim();
    }
}