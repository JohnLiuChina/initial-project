package com.example.config.framework.selector;

import com.example.beans.StuA;
import com.example.beans.StuB;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{StuA.class.getName(), StuB.class.getName()};
    }
}
