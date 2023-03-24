package com.todoist.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectsModel {

    private String id;

    @JsonProperty("parent_id")
    private String parentId;

    private Integer order;

     private String color;

    private String name;

    @JsonProperty("comment_count")
    private Integer commentCount;

    @JsonProperty("is_shared")
    private Boolean isShared;

    @JsonProperty("is_favorite")
    private Boolean isFavorite;

    @JsonIgnore
    @JsonProperty("is_inbox_project")
    private String isInboxProject;

    @JsonProperty("is_team_inbox")
    private Boolean isTeamInbox;

    private String url;

    @JsonProperty("view_style")
    private String viewStyle;
}
