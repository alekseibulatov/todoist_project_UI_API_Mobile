
package com.todoist.tests.api.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponseAllProjectsModel {


   //  @JsonProperty("ProjectsModels")
   //  private List<ProjectsModel> source;
 //private  ProjectsModel [] projectsModels;

private List<ProjectsModel> list;
//private ProjectsModel[] projectsModels;

 //  private ProjectsModel[] projectsModels;
}

