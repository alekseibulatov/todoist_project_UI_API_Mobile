
package com.todoist.tests.api.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponseAllProjectsModel {


    private ArrayList<ProjectsModel> list;

}

