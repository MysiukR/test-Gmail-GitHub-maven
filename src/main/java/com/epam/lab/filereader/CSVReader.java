package com.epam.lab.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.lab.filereader.PropertyReader.usersGitHubPath;
import static com.epam.lab.utils.Constants.CVS_SPLIT_BY;
import static com.epam.lab.utils.Constants.LINE_SEPARATE;

public class CSVReader {
    private PropertyReader propertyReader;

    public Object[][] readCSVfile() {
        List<ModelGitUsers> userModels = new ArrayList<>();
        String[] userData;
        propertyReader = new PropertyReader();
        propertyReader.readProperties();
        try (BufferedReader br = new BufferedReader(new FileReader(usersGitHubPath))) {
            while ((LINE_SEPARATE = br.readLine()) != null) {
                userData = LINE_SEPARATE.split(CVS_SPLIT_BY);
                ModelGitUsers gitData = new ModelGitUsers();
                gitData.setLogin(userData[0]);
                gitData.setPassword(userData[1]);
                userModels.add(gitData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseDataFromCsvObjects(userModels);
    }

    public static Object[][] parseDataFromCsvObjects(List<ModelGitUsers> listUsers) {
        Object[][] objects = new Object[listUsers.size()][2];
        for (int i = 0; i < listUsers.size(); i++) {
            objects[i][0] = listUsers.get(i).getLogin();
            objects[i][1] = listUsers.get(i).getPassword();
        }
        return objects;
    }
}