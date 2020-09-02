package review.dao;

import java.util.ArrayList;

import model.ProductOrderVO;
import model.ReviewVO;



public interface Dao {
	int selectNum();

	void insert(ReviewVO notice);

	ReviewVO select(int p_num);
	
	ArrayList<ReviewVO> selectByP_Num(int p_num);

	void update(ReviewVO notice);

	void delete(int num);

	ArrayList<ReviewVO> selectAll();

	ArrayList<ReviewVO> myselectAll(String m_id);
}
