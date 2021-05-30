package com.aem.training.site.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Locale;
import java.util.Set;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class} , adapters = Author.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class AuthorImpl extends Author {

    @OSGiService
    private SlingSettingsService settings;

    @Inject
    SlingHttpServletRequest request;

    @ValueMapValue
    String fname;

    @ValueMapValue
    String lname;

    @PostConstruct

    public void init()
    {
       // String path= request.getResource().getPath();
       // ResourceResolver resolver=request.getResourceResolver();
       // Resource res =resolver.getResource( "/content");

        fname=fname.toUpperCase(Locale.ROOT);
        lname=lname.toUpperCase(Locale.ROOT);
      //  Set<String> runmodes=settings.getRunModes();
    }

    @Override
    public String getFirstName() {
        return fname;

    }
    @Override
    public String getLastName() {
        return lname;

    }



//    @Override
//    String getMidName() {
//        return midname;
//    }



//    @Inject
//    Boolean professor;




//    public String setFname(String fname) {
//        this.fname = fname;
//        return(this.fname);
//
//    }
//
//    public String setLname() {
//        this.lname = lname;
//        return (this.lname)
//    }
    //    @Override
//    public Boolean isProfessor() {
//        return professor;
//    }


}
