package com.aem.training.site.core.models;

import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = HeaderModel.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HeaderModel {
    protected static final String RESOURCE_TYPE = "training/components/task_header";

    private static final Logger log = LoggerFactory.getLogger(HeaderModel.class);



    @ChildResource
    private Resource slides;

    private List<Item> headerSlides = new ArrayList<>();

    @PostConstruct
    protected void init(){
        log.debug("init method called for header");

        if (Objects.nonNull(slides)){

            for (Resource res:
                 slides.getChildren()) {

                Item item = new Item();
                ValueMap vm = res.getValueMap();

                item.setTitle(vm.containsKey("title") ? vm.get("title", String.class) : StringUtils.EMPTY);

                headerSlides.add(item);

            }

        }

    }

    public List<Item> getHeaderSlides() {
        return headerSlides;
    }
}
