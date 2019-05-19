package mx.template.base.util;

import lombok.extern.slf4j.Slf4j;
import mx.template.base.exception.DataException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author peidong.meng
 */
@Slf4j
public class ModelEntityUtils {

    /**
     * 复制对象
     * dest    新对象
     * origin  被复制对象
     */
    public static <D, O> D copyProperties(D dest, O origin) throws DataException {
        try {
            BeanUtils.copyProperties(origin, dest);
            return dest;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DataException("model convert error: " + e.getMessage());
        }
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null){
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 复制非空属性
     * @param src
     * @param target
     */
    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }


    /**
     * 检查实体中为空的字段
     * @param object 实体
     * @param ignoreFields 可以为空的字段
     * @return
     */
    public static List<String> checkObjFieldIsNull(Object object, String...ignoreFields){
        List<String> result = new ArrayList<>();
        //可以为空的字段列表
        List<String> list = ignoreFields == null ? new ArrayList() : Arrays.asList(ignoreFields);
        try {

            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                //可忽略的空字段
                if(list.contains(f.getName())){
                    continue;
                }
                if (f.get(object) == null) {
                    result.add(f.getName());
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

}
