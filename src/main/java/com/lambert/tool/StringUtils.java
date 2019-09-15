package com.lambert.tool;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

import java.io.IOException;
import java.io.Writer;

/**
 * @author lambert
 * @version $Id: StringUtils.java, v 0.1 2019年09月15日 9:54 PM lambert Exp $
 */
public class StringUtils{


   public static String toUpperCaseFirstOne(String value){
       char[] chars = value.toCharArray();
       if (chars[0] >= 'a' && chars[0] <= 'z') {
           chars[0] = (char)(chars[0] - 32);
       }

       return new String(chars);

   }
}
