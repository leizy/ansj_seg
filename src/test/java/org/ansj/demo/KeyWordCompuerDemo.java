package org.ansj.demo;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;

import java.util.Collection;

/**
 * 关键词提取的例子
 * @author ansj
 *
 */
public class KeyWordCompuerDemo {
	public static void main(String[] args) {
		KeyWordComputer kwc = new KeyWordComputer(20);
		String title = "华人富豪千万美元买房，与新西兰总理做邻居";
		String content = "据新西兰天维网援引NZ Herald消息报道，近日，新西兰华人土豪再次出手，以1010万的价格购买了位于Parnell的一座无敌海景豪宅。 该房产原主人是汽车经销商Bob McMillan和妻子Kerry，由Graham Wall房地产公司负责出售。房产经纪Ollie和Andrew Wall介绍，该物业面积450平方米，拥有超大车库、温控酒窖、加热泳池、露天桑拿、每层都有直达电梯等等，还带有一个面朝城市的办公室，而且每个房间都坐拥无敌景致。 该房产的价值约为920万刀，中介Walls表示，由于新西兰元走低，海外买家对奥克兰房产的兴趣不断升温，“房子最终卖给了一个中国家庭，”他们说。 这座位于St Stephens Ave的房产其实是与总理John Key家在同一条街上，“海外买家十分热衷，”Graham Wall表示，“而且，由于纽币汇率的原因，国际买家对奥克兰的豪宅十分感兴趣，我们最近一直在忙于许多美国富豪的需求，但其实奥克兰根本提供不了足够的完美房产。” 据悉，原房主Mcmillan夫妇之前是Team McMillan BMW成员，这所位于St Stephens Ave的豪宅是他们自己建造的。";
		Collection<Keyword> result = kwc.computeArticleTfidf(title, content);
		System.out.println(result);
	}
}
