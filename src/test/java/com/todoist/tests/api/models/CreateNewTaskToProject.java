package com.todoist.tests.api.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateNewTaskToProject {

    private String content;

    @JsonProperty("project_id")
    private String projectId;
}
