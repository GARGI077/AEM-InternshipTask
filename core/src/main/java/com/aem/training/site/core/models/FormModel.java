//package com.aem.training.site.core.models;
//
//import com.aem.training.site.core.servlets.CityServlet;
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.resource.ResourceResolver;
//import org.apache.sling.api.resource.ValueMap;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.settings.SlingSettingsService;
//import org.osgi.resource.Resource;
//
//import javax.inject.Inject;
//import java.util.Collections;
//import java.util.List;
//
//@Model(adaptables = {SlingHttpServletRequest.class,})
//public class FormModel {
//
//    @Inject
//    CityServlet cityServlet;
//
//    @Inject
//    SlingHttpServletRequest request;
//
//    private List<FormItem> cityList = Collections.emptyList();
//
//
//    protected void init() {
//
//        ResourceResolver resolver = request.getResourceResolver();
//        Resource resource = (Resource) resolver.getResource("/content/training/State");
//      //  Iterable<Resource> childResources = resource.getChildren();
//
//        FormItem im = new FormItem();
//
//        ValueMap vm = resource.getValueMap("/content/training/State");
//        String title = vm.get("title", String.class);
//        im.setTitle(title);
//        cityList.add(im);
//    }
//
//    public List<FormItem> getCityList() {
//        return cityList;
//    }
//}
//}
