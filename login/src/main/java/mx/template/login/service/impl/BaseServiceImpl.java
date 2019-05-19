package mx.template.login.service.impl;

import java.util.List;

/**
 * @author peidong.meng
 * @date 2019/5/19
 */
public interface BaseServiceImpl<E> {

    /**
     * 基础新增
     * @param e 新增dto
     * @return 成功个数
     */
    int save(E e);

    /**
     * 基础修改
     * @param e 修改dto
     * @return 成功个数
     */
    int update(E e);

    /**
     * 基础删除
     * @param e 删除dto
     * @return 成功个数
     */
    int delete(E e);

    /**
     * 基础获取列表
     */
    List<E> list();

    /**
     * 根据主键查询实体
     * @return 返回查询后的dto
     */
    E view(Integer id);
}
