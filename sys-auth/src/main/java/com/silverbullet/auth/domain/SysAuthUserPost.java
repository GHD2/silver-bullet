package com.silverbullet.auth.domain;

public class SysAuthUserPost {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_auth_userpost.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_auth_userpost.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_auth_userpost.post_id
     *
     * @mbggenerated
     */
    private String postId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_auth_userpost.id
     *
     * @return the value of sys_auth_userpost.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_auth_userpost.id
     *
     * @param id the value for sys_auth_userpost.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_auth_userpost.user_id
     *
     * @return the value of sys_auth_userpost.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_auth_userpost.user_id
     *
     * @param userId the value for sys_auth_userpost.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_auth_userpost.post_id
     *
     * @return the value of sys_auth_userpost.post_id
     *
     * @mbggenerated
     */
    public String getPostId() {
        return postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_auth_userpost.post_id
     *
     * @param postId the value for sys_auth_userpost.post_id
     *
     * @mbggenerated
     */
    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }
}