package com.yuanyuansinian.model.hall;

public class HallWithBLOBs extends Hall {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.img_index
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private byte[] img_index;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ujn_hall.achievement
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    private String achievement;
    
    //生平事迹
    private String life_story;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.img_index
     *
     * @return the value of ujn_hall.img_index
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public byte[] getImg_index() {
        return img_index;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.img_index
     *
     * @param img_index the value for ujn_hall.img_index
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setImg_index(byte[] img_index) {
        this.img_index = img_index;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ujn_hall.achievement
     *
     * @return the value of ujn_hall.achievement
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public String getAchievement() {
        return achievement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ujn_hall.achievement
     *
     * @param achievement the value for ujn_hall.achievement
     *
     * @mbg.generated Fri Mar 10 16:01:30 CST 2017
     */
    public void setAchievement(String achievement) {
        this.achievement = achievement == null ? null : achievement.trim();
    }

	public String getLife_story() {
		return life_story;
	}

	public void setLife_story(String life_story) {
		this.life_story = life_story;
	}
}