package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * Copyright (C), 2016-${.now?string("yyyy")}, Mobius-Vision
 * FileName: ${table.serviceName}
 * Author: ${author}
 * Date: ${.now}
 * Description: ${table.comment!} 服务类
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
