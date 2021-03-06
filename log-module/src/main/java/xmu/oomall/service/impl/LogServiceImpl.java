package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.LogDao;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.domain.Log;
import xmu.oomall.service.LogService;

import java.util.List;


/**
 * @author CFH 12/23
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;


    /**
     * 根据管理员ID查找日志列表
     *
     * @param adminId 管理员ID
     * @param page    分页页号
     * @param limit   分页大小
     * @return 该管理员的操作日志列表
     */
    @Override
    public List<Log> findLogListByAdminId(Integer adminId, Integer page, Integer limit) {
        List<Log> logList=logDao.findLogListByAdminId(adminId);
        return divideByPage(logList,page,limit);
    }

    /**
     * 添加日志
     *
     * @param log 待添加的日志信息
     * @return 新增的日志
     */
    @Override
    public Log addLog(Log log) {
        return logDao.addLog(log);
    }

    /**
     * 分页功能
     *
     * @param list 父列表
     * @param page 分页页数
     * @param limit 分页大小
     * @param <T> 列表元素类型
     * @return 子列表
     */
    private <T> List<T> divideByPage(List<T> list,Integer page,Integer limit){
        int maxPages=(list.size()-1)/limit+1;
        if(page<maxPages){
            return list.subList((page-1)*limit,page*limit);
        }
        if(page==maxPages){
            return list.subList((page-1)*limit,list.size());
        }
        //page>maxPages
        return list.subList(0,0);
    }
}
