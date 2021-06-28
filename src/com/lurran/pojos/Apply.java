package com.lurran.pojos;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:53 下午
 */
public class Apply {

    private Integer applyId;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String weChat;
    private String idCard;
    private String province;
    private String postAddress;
    private String occupation;
    private Integer userId;

    public Apply() {
    }

    @Override
    public String toString() {
        return "Apply{" +
                "userId=" + userId +
                ", applyId=" + applyId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", weChat='" + weChat + '\'' +
                ", idCard='" + idCard + '\'' +
                ", province='" + province + '\'' +
                ", postAddress='" + postAddress + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Apply(Integer applyId, String name, String gender, String phone, String email, String weChat, String idCard, String province, String postAddress, String occupation, Integer userId) {
        this.applyId = applyId;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.weChat = weChat;
        this.idCard = idCard;
        this.province = province;
        this.postAddress = postAddress;
        this.occupation = occupation;
        this.userId = userId;
    }

    public Apply(String name, String gender, String phone, String email, String weChat, String idCard, String province, String postAddress, String occupation, Integer userId) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.weChat = weChat;
        this.idCard = idCard;
        this.province = province;
        this.postAddress = postAddress;
        this.occupation = occupation;
        this.userId = userId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
