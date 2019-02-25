package com.practice.ssm.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.practice.ssm.util.PageBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-15 15:05
 */
@Component
@Aspect
public class PagerAspect {

    /**
     * 环绕通知注解，  添加execution切面针对哪些类的哪些方法
     *  返回类型不限  任意包  以Service命名的接口   以Pager结尾的方法   传入参数不限
     *
     *  invoke方法内容:调用*Pager方法环绕通知执行的内容（业务逻辑）
     * @param args
     * @return
     */
    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {
        //获取*Pager方法参数
        Object[] param = args.getArgs();
        //如果说pager方法含有pagebean，则分页
        PageBean pageBean = null;
        for (Object o : param) {
            //类类型为pagebean 向上转型为pagebean参数
            if(o instanceof PageBean) {
                pageBean = (PageBean) o;
                break;
            }
        }
        if(pageBean != null && pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        }
        //通过方法参数,拿到执行方法后的返回结果集
        Object proceed = args.proceed(param);
        if(pageBean != null && pageBean.isPagination()) {
            PageInfo pageInfo = new PageInfo((List) proceed);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return proceed;
    }
}
