package com.xun.playground.horror.story.domain;

/**
 * 무서운이야기 컨텐츠
 */
public class HorrorStoryDomain {
    // 작성자 id
    private String id;
    // 작성자 이름
    private String name;
    // 조회수
    private String viewCount;
    // 제목
    private String title;
    // 내용
    private String content;
    // 작성날짜
    private String enterDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }
}
