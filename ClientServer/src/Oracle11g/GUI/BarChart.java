package Oracle11g.GUI;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import Oracle11g.Entity.AbstractAdmin;
import Oracle11g.Entity.Line;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;

class Count{
    private int from;
    private int to;

    public Count()
    {
        this.from = 0;
        this.to = 0;
    }

    public Count(int from, int to)
    {
        this.from = from;
        this.to = to;
    }

    public void setFrom(int from)
    {
        this.from = from;
    }

    public void setTo(int to)
    {
        this.to = to;
    }

    public int getFrom()
    {
        return this.from;
    }

    public int getTo()
    {
        return this.to;
    }
}

public class BarChart {
	ChartPanel frame1;
	public  BarChart() throws Exception{
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "路线统计", // 图表标题
                            "城市", // 目录轴的显示标签
                            "数量", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
          
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
          
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         
	}
	   private static CategoryDataset getDataSet() throws Exception{
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           List<Line> list = AbstractAdmin.getAdmin().getLine("");
            Map<String, Count> map = new HashMap<>();
            for(Line h : list){
                String from_city = h.getT_city();
                String to_city = h.getR_city();
                Count c_from = new Count(1, 0);
                if(map.containsKey(from_city)){
                    c_from.setFrom(map.get(from_city).getFrom() + 1);
                    c_from.setTo(map.get(from_city).getTo());
                }
                map.put(from_city, c_from);
                Count c_to = new Count(0, 1);
                if(map.containsKey(to_city)){
                    c_from.setFrom(map.get(to_city).getFrom());
                    c_from.setTo(map.get(to_city).getTo() + 1);
                }
                map.put(to_city, c_to);
            }
            for(Entry<String, Count> entry : map.entrySet()){
                dataset.addValue(entry.getValue().getFrom(), "出发", entry.getKey());
                dataset.addValue(entry.getValue().getTo(), "到达", entry.getKey());
            }
        //    dataset.addValue(100, "北京", "苹果");
        //    dataset.addValue(100, "上海", "苹果");
        //    dataset.addValue(100, "广州", "苹果");
        //    dataset.addValue(200, "北京", "梨子");
        //    dataset.addValue(200, "上海", "梨子");
        //    dataset.addValue(200, "广州", "梨子");
        //    dataset.addValue(300, "北京", "葡萄");
        //    dataset.addValue(300, "上海", "葡萄");
        //    dataset.addValue(300, "广州", "葡萄");
        //    dataset.addValue(400, "北京", "香蕉");
        //    dataset.addValue(400, "上海", "香蕉");
        //    dataset.addValue(400, "广州", "香蕉");
        //    dataset.addValue(500, "北京", "荔枝");
        //    dataset.addValue(500, "上海", "荔枝");
        //    dataset.addValue(500, "广州", "荔枝");
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}
}

