package com.github.hcsp.descriptorparser;

/**
 * 代表引用类型的描述符号
 */
public class ReferenceDescriptor implements TypeDescriptor {
    /**
     * 全限定类名，如java.lang.Object
     */
    private String fqcn;
    private String descriptor;

    public ReferenceDescriptor(String descriptor) {
        int start = 0;
        int end = descriptor.length();
        if (descriptor.startsWith("L")) {
            start++;
        }
        if (descriptor.endsWith("$") || descriptor.endsWith(";")) {
            end--;
        }
        fqcn = descriptor.substring(start, end).replace("/",".");

    }

    @Override
    public String getName() {
        return fqcn;
    }

    @Override
    public String getDescriptor() {
        return descriptor;
    }
}
