package com.egfbank.threadpool.data;

public class AnalyzeResult {
	// 增长率
		private int growRate;
		// 总收入
		private int totalIncome;
		// 成本
		private int cost;
		// 利润
		private int profit;
		
		public AnalyzeResult() {
			super();
		}
		
		public void  calculate(){
			this.setCost(1000);
			this.setGrowRate(80);
			this.setProfit(2000);
			this.setTotalIncome(3000);
		}

		
		
		@Override
		public String toString() {
			return "DataAnalyze [growRate=" + growRate + ", totalIncome="
					+ totalIncome + ", cost=" + cost + ", profit=" + profit + "]";
		}

		public int getGrowRate() {
			return growRate;
		}

		public void setGrowRate(int growRate) {
			this.growRate = growRate;
		}

		public int getTotalIncome() {
			return totalIncome;
		}

		public void setTotalIncome(int totalIncome) {
			this.totalIncome = totalIncome;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public int getProfit() {
			return profit;
		}

		public void setProfit(int profit) {
			this.profit = profit;
		}
		
		
}
