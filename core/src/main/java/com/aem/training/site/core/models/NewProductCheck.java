//package com.aem.training.site.core.models;
//import com.adobe.cq.export.json.ExporterConstants;
//import com.aem.training.site.core.services.SimpleService;
//import com.aem.training.site.core.services.SimpleServiceConfiguration;
//import com.aem.training.site.core.services.impl.SimpleServiceImpl;
//import com.day.cq.search.QueryBuilder;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.resource.*;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Exporter;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.OSGiService;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//import org.osgi.service.component.annotations.Activate;
//import org.osgi.service.component.annotations.Modified;
//import org.osgi.service.component.annotations.Reference;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//
//@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = Product_Model.RESOURCE_TYPE)
//@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
//public class NewProductCheck {
//
//    protected static final String RESOURCE_TYPE = "training/components/new_product";
//
//    @OSGiService
//    private SimpleService simpleService;
//    private List<Bike> bikeList = Collections.emptyList();
//
//
//    @PostConstruct
//    protected void init() {
//        bikeList = simpleService.getBikeList();
//
//
//    }
//
//
//    public static final String SAMPLESYSTEMUSER = "samplesystemuser";
//    private static final Logger log = LoggerFactory.getLogger(SimpleServiceImpl.class);
//
//    String path = StringUtils.EMPTY;
//
//    @ValueMapValue
//    private String text;
//
//    @Reference
//    ResourceResolverFactory resourceResolverFactory;
//
//    @Reference
//    private QueryBuilder queryBuilder;
//
//    @Activate
//    @Modified
//    protected void activateOrModified(SimpleServiceConfiguration config){
//        path = config.service_path();
//        System.out.println(path);
//    }
//
//    @Override
//    public List<Bike> getBikeList(){
//        ResourceResolver resourceResolver=getResourceResolver(resourceResolverFactory,SAMPLESYSTEMUSER);
//        List<Bike> bikesList = new ArrayList<>();
//        Resource parentResource = resourceResolver.getResource(text);
//        if (Objects.nonNull(parentResource)){
//
//            for (Resource res: parentResource.getChildren()) {
//                ValueMap vm = res.getValueMap();
//                Bike bike = new Bike();
//                bike.setTitle(vm.get("jcr:title",String.class));
//                bike.setPrice(vm.get("price", String.class));
//                bike.setDescription(vm.get("summary", String.class));
//                bike.setRating(vm.get("rating", String.class));
//                bike.setReviews(vm.get("reviews", String.class));
//
//                bikesList.add(bike);
//            }
//        }
//        return bikesList;
//    }
//
//    private ResourceResolver getResourceResolver(final ResourceResolverFactory resourceResolverFactory,
//                                                 final String subService) {
//        ResourceResolver resourceResolver = null;
//        if (null != resourceResolverFactory && null != subService) {
//            try {
//                final Map<String, Object> authInfo = new HashMap<>();
//                authInfo.put(ResourceResolverFactory.SUBSERVICE, subService);
//                resourceResolver = resourceResolverFactory.getServiceResourceResolver(authInfo);
//            } catch (final LoginException loginException) {
//                log.error("exception occured");
//            }
//        }
//        return resourceResolver;
//    }
//
//
//    public List<Bike> getBikeList() {
//        return bikeList;
//    }
//
//}
