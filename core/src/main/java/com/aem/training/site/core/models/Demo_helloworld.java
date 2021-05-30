package com.aem.training.site.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.resource.Resource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Locale;
import java.util.Set;

@Model(
        adaptables ={Resource.class, SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class Demo_helloworld {



    @ValueMapValue(name = "text")
    public String title;

    @OSGiService
    private SlingSettingsService setting;

    @Inject
    SlingHttpServletRequest request;


    @PostConstruct
    protected void init()
    {
       // String path=request.getResource().getPath();
      //  ResourceResolver resolver= request.getResourceResolver();// fetching path of the resource that iss the components we are creating
      //  Resource res=resolver.getResource("/content/training/us/en");


        title=title.toUpperCase(Locale.ROOT);
        Set<String> runmode=setting.getRunModes();

        System.out.println("runmodes");



    }
    public String getTitle() {
        return title;
    }


}
