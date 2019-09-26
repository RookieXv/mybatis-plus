package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};


/**
 * Copyright (C), 2016-${.now?string("yyyy")}, Mobius-Vision
 * FileName: ${table.mapperName}
 * Author: ${author}
 * Date: ${.now}
 * Description: ${table.comment!} Mapper 接口
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
