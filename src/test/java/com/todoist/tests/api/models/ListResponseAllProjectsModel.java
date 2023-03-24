
package com.todoist.tests.api.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponseAllProjectsModel {

    @JsonProperty("")
    private List<ProjectsModel> list;

}

