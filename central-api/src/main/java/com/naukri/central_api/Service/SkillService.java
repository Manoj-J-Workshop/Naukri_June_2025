package com.naukri.central_api.Service;

import com.naukri.central_api.connectors.DatabaseApiConnectors;
import com.naukri.central_api.models.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    DatabaseApiConnectors databaseApiConnectors;

    @Autowired
    public SkillService(DatabaseApiConnectors databaseApiConnectors){
        this.databaseApiConnectors = databaseApiConnectors;
    }


    public List<Skills> getAllSkills(List<String> SkillsNames){
        List<Skills> skillsList =  new ArrayList<>();

        if (SkillsNames == null || SkillsNames.isEmpty()) {
            return skillsList;   // avoid NPE
        }

        for(int i = 0; i < SkillsNames.size(); i++) {
            String skillName = SkillsNames.get(i);
            Skills skill = this.getSkillByName(skillName);
            skillsList.add(skill);
        }
        return skillsList;
    }


    public Skills createSkillByName(String SkillName){
        Skills skill = new Skills();
        skill.setSkillName(SkillName);
        //call DB API connector to save skill in DB
        return databaseApiConnectors.callSaveSkillEndpoint(skill);
    }

    public Skills getSkillByName(String skillName){
        // This function call DB API SkllsController, that will bring Skills object from the Database
        // Note: Convert skillName (String) to Skills(class object)
        // we need to get Skills(class object) from database api on the basis of skillName (String)
        // we need to call DB api from here.
        Skills skill = databaseApiConnectors.callGetSkillsByNameEndpoint(skillName);
        if(skill == null){
            // skill came as null, that skill does not exsist in DB, so we need to create skill in the skill tbl
            return this.createSkillByName(skillName);
        }
        return skill;

    }
}
