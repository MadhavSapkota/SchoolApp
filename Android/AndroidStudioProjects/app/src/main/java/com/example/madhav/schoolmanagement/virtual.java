
//https://github.com/xrezut/FirebaseRecyclerViewTutorial/tree/master/app/src/main/res/layout

package com.example.madhav.schoolmanagement;

/**
 * Created by xrezut on 03/03/2018.
 */

public class virtual {

    private String title;
    private String desc;
    private String image;
    private String url;

    public virtual(String title, String desc, String image, String url) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.url = url;
    }

    public virtual(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
