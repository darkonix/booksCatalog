package com.example.bookscatalog.repositoryAPI;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class book {

    @SerializedName("cover_i")
    @Expose
    private Integer coverI;
    @SerializedName("has_fulltext")
    @Expose
    private Boolean hasFulltext;
    @SerializedName("edition_count")
    @Expose
    private Integer editionCount;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author_name")
    @Expose
    private List<String> authorName = null;
    @SerializedName("first_publish_year")
    @Expose
    private Integer firstPublishYear;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("ia")
    @Expose
    private List<String> ia = null;
    @SerializedName("author_key")
    @Expose
    private List<String> authorKey = null;
    @SerializedName("public_scan_b")
    @Expose
    private Boolean publicScanB;

    public Integer getCoverI() {
        return coverI;
    }

    public void setCoverI(Integer coverI) {
        this.coverI = coverI;
    }

    public Boolean getHasFulltext() {
        return hasFulltext;
    }

    public void setHasFulltext(Boolean hasFulltext) {
        this.hasFulltext = hasFulltext;
    }

    public Integer getEditionCount() {
        return editionCount;
    }

    public void setEditionCount(Integer editionCount) {
        this.editionCount = editionCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }

    public Integer getFirstPublishYear() {
        return firstPublishYear;
    }

    public void setFirstPublishYear(Integer firstPublishYear) {
        this.firstPublishYear = firstPublishYear;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getIa() {
        return ia;
    }

    public void setIa(List<String> ia) {
        this.ia = ia;
    }

    public List<String> getAuthorKey() {
        return authorKey;
    }

    public void setAuthorKey(List<String> authorKey) {
        this.authorKey = authorKey;
    }

    public Boolean getPublicScanB() {
        return publicScanB;
    }

    public void setPublicScanB(Boolean publicScanB) {
        this.publicScanB = publicScanB;
    }

    @Override
    public String toString() {
        return "\nbook{" +
                "coverI=" + coverI +
                ", hasFulltext=" + hasFulltext +
                ", editionCount=" + editionCount +
                ", title='" + title + '\'' +
                ", authorName=" + authorName +
                ", firstPublishYear=" + firstPublishYear +
                ", key='" + key + '\'' +
                ", ia=" + ia +
                ", authorKey=" + authorKey +
                ", publicScanB=" + publicScanB +
                '}';
    }
}
