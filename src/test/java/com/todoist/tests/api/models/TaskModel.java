package com.todoist.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskModel {

    private String id;

    @JsonProperty("assigner_id")
    private String assignerId;

    @JsonProperty("assignee_id")
    private String assigneeId;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("section_id")
    private String sectionId;

    @JsonProperty("parent_id")
    private String parentId;

    private Integer order;

    private String content;
}
