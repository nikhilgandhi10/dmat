package com.api.dmat.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.dmat.model.DevopsPractice;
import com.api.dmat.model.DisplayCategories;
import com.api.dmat.repo.DevopsPracticeRepo;
import com.api.dmat.repo.DisplayCategoriesRepo;

@Component
public class DBUtility {

	@Autowired
	DisplayCategoriesRepo displaycategoriesrepo;
	@Autowired
	DevopsPracticeRepo devopspracticesrepo ;

	// To fetch the Tab Category names from the repository and provide to thes Service
	public List<String> getDisplayCategoryTabNames() {
		// Fetch all the Display Categories present
		List<DisplayCategories> displaycategorieslist = displaycategoriesrepo.findAll();
		List<String> displaycategorynameslist = new ArrayList<>();
		// To fetch all the categories and add them to the String Array
		for (DisplayCategories displaycategories : displaycategorieslist) {
			displaycategorynameslist.add(displaycategories.getName());
		}
		return displaycategorynameslist;
	}

	// To fetch the DevopsPractice Tab Category names from the repository and provide to thes Service
	public List<String> getDevopsPracticesNames() {
		// Fetch all the Devops Practices  Categories present
		List<DevopsPractice> devopspracticeList = devopspracticesrepo.findAll();
		List<String> devopspracticeNamesList = new ArrayList<>();
		// To fetch all the categories and add them to the String Array
		for (DevopsPractice devopsPractices : devopspracticeList) {
			devopspracticeNamesList.add(devopsPractices.getName());
		}
		return devopspracticeNamesList;
	}
}
