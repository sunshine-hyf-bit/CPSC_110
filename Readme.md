import IPython.display as display

content = r'''
# **需要学习的知识点**

## **1. 线性模型的基本概念**
线性模型的核心思想是用**线性函数**来近似数据之间的关系。主要包括：
- **线性回归（Linear Regression）**：用于**回归任务**，预测连续值，如房价预测。
- **逻辑回归（Logistic Regression）**：用于**分类任务**，通过 sigmoid 函数输出类别概率，如邮件分类（垃圾邮件 vs 正常邮件）。
- **线性支持向量机（Linear SVM）**：用于**分类任务**，寻找最大化类别间隔的超平面。

## **2. 线性回归 (Linear Regression)**
线性回归的目标是找到最优的线性关系：
\[
\hat{y} = w_1x_1 + w_2x_2 + \dots + w_nx_n + b
\]
其中：
- \( \hat{y} \) 是预测值，
- \( x_i \) 是输入特征，
- \( w_i \) 是特征对应的权重（系数），
- \( b \) 是偏置项（截距）。

### **2.1 线性回归的损失函数**
最常见的损失函数是**均方误差（MSE, Mean Squared Error）**：
\[
J(w) = \frac{1}{N} \sum_{i=1}^{N} (y_i - \hat{y_i})^2
\]
通过最小化这个损失函数，我们可以使用**梯度下降**或者**正规方程**来求解 \( w \) 和 \( b \)。

### **2.2 权重推导**
最优权重 \( w \) 通过最小化 MSE 计算：
\[
w = (X^TX)^{-1}X^Ty
\]
其中：
- \( X \) 是特征矩阵，
- \( y \) 是目标值向量，
- \( (X^TX)^{-1}X^T \) 是伪逆矩阵。

## **3. Ridge 回归**
Ridge 回归是**带 L2 正则化的线性回归**，其损失函数为：
\[
J(w) = \frac{1}{N} \sum_{i=1}^{N} (y_i - \hat{y_i})^2 + \alpha \sum_{j=1}^{n} w_j^2
\]
- 额外的**正则化项** \( \alpha \sum w_j^2 \) 控制权重的大小，防止过拟合。
- **较小的 \( \alpha \)**：模型更复杂，更可能过拟合。
- **较大的 \( \alpha \)**：模型更简单，更可能欠拟合。

### **3.1 Ridge 的权重推导**
\[
w = (X^TX + \alpha I)^{-1}X^Ty
\]
与普通线性回归的区别在于**增加了一个正则化项** \( \alpha I \)，使矩阵更稳定，避免特征共线性问题。

## **4. 逻辑回归 (Logistic Regression)**
逻辑回归用于**分类任务**，它的核心思想是：
- 通过 sigmoid 函数将线性回归的输出映射到 \([0,1]\) 范围，表示类别的概率：
\[
P(y=1 | x) = \frac{1}{1 + e^{-(w_1x_1 + w_2x_2 + ... + w_nx_n + b)}}
\]
- 预测类别时：
  - 如果 \( P(y=1 | x) > 0.5 \)，分类为 1；
  - 否则，分类为 0。

### **4.1 逻辑回归的损失函数**
逻辑回归使用**对数损失函数（Log Loss）**：
\[
J(w) = - \frac{1}{N} \sum_{i=1}^{N} [y_i \log \hat{y_i} + (1 - y_i) \log (1 - \hat{y_i})]
\]
通过梯度下降优化 \( w \) 以最小化损失。

## **5. 线性支持向量机（Linear SVM）**
线性 SVM 也是用于分类的线性模型，目标是找到**最大化类别间隔的超平面**：
\[
w^Tx + b = 0
\]
SVM 的优化目标是**最大化间隔（Margin）**，其损失函数为**Hinge Loss**：
\[
J(w) = \sum_{i=1}^{N} \max(0, 1 - y_i (w^T x_i + b)) + \frac{\lambda}{2} \sum w_j^2
\]

## **问题解答**
### **Ridge 回归**
✅ **(A) 增大 Ridge 的超参数 \( \alpha \) 会降低模型复杂度**（正则化更强，权重更小）。  
✅ **(B) Ridge 可以用于具有多个特征的数据集**（可以处理高维数据）。  
❌ **(C) Ridge 对整个数据集学习一个全局的系数，而不是每个样本一个**。  
✅ **(D) 训练 2 维特征的线性回归模型时，模型会学习 3 个参数：两个特征权重 + 一个偏置项**。  

### **逻辑回归**
✅ **(A) 增大逻辑回归的 \( C \) 超参数会增加模型复杂度**（减少正则化）。  
✅ **(B) 逻辑回归的原始得分（线性回归输出）可以用于计算概率**（通过 sigmoid 函数）。  
✅ **(C) 逻辑回归的决策边界是一个 \( d-1 \) 维超平面**（训练 \( d \) 维特征时，决策边界维度减少 1）。  
✅ **(D) 线性模型对于靠近决策边界的数据点不确定性较高**（概率接近 0.5）。  
'''

display.Markdown(content)
