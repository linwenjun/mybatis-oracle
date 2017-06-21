package cn.wenjun.learning.util;

import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;

public class CommonOperations {

    public static Operation DELETE_ALL = deleteAllFrom("BLOG");
}
