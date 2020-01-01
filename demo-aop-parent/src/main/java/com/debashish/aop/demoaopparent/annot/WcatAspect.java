package com.debashish.aop.demoaopparent.annot;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WcatAspect {
}
