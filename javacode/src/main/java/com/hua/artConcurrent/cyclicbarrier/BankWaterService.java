package com.hua.artConcurrent.cyclicbarrier;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class BankWaterService implements Runnable {
    // 创建4个屏障 处理完之后 之心run方法
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

    // 假设有4个sheel 故启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);

    // 保存每个sheet计算出来的结果
    private Map<String, Integer> sheetBankWaterCountMap = Maps.newConcurrentMap();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCountMap.put(Thread.currentThread().getName(), 1);

                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> entry : sheetBankWaterCountMap.entrySet()) {
            result += entry.getValue();
        }
        sheetBankWaterCountMap.put("countReslt", result);
        System.out.printf("counrResult==" + result + "\n");
    }

    public Map<String, Integer> getSheetBankWaterCountMap() {
        return sheetBankWaterCountMap;
    }

    public void setSheetBankWaterCountMap(Map<String, Integer> sheetBankWaterCountMap) {
        this.sheetBankWaterCountMap = sheetBankWaterCountMap;
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
        System.out.printf("计算结果为:" + bankWaterService.getSheetBankWaterCountMap().get("countReslt"));
    }
}
