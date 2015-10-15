package DynamicPrograming;

import java.util.Arrays;

public class BoxStacking {
	
	/**
	 * @author tusroy
	 * 
	 * Given different dimensions and unlimited supply of boxes for each dimension, stack boxes
	 * on top of each other such that it has maximum height but with caveat that length and width
	 * of box on top should be strictly less than length and width of box under it. You can
	 * rotate boxes as you like.
	 * 
	 * 1) Create all rotations of boxes such that length is always greater or equal to width
	 * 2) Sort boxes by base area in non increasing order (length * width). This is because box
	 * with more area will never ever go on top of box with less area.
	 * 3) Take T[] and result[] array of same size as total boxes after all rotations are done
	 * 4) Apply longest increasing subsequence type of algorithm to get max height.
	 * 
	 * If n number of dimensions are given total boxes after rotation will be 3n.
	 * So space complexity is O(n)
	 * Time complexity - O(nlogn) to sort boxes. O(n^2) to apply DP on it So really O(n^2)
	 *
	 */
	
	public static int maxHeight(Dimension[] input) {
		//get all rotations of box dimension.
        //e.g if dimension is 1,2,3 rotations will be 2,1,3  3,2,1  3,1,2  . Here length is always greater
        //or equal to width and we can do that without loss of generality.
		Dimension[] allRotationInput = new Dimension[input.length * 3];
		createAllRotation(input, allRotationInput);
		
		// Sort the boxes in decreasing order of their base area (if base area of b1 is greater than b2 then it can never be placed over b2)
		Arrays.sort(allRotationInput);
		
		// Apply LIS concept 
		int[] max_heights = new int[allRotationInput.length];
		int[] result = new int[allRotationInput.length];		
		
		/* Initialize max_heights array with respective heights and results with respective box numbers */
		for (int i=0;i<max_heights.length;i++) {
			max_heights[i] = allRotationInput[i].height;
			result[i] = i;
		}
		
		for (int i=1;i<max_heights.length;i++) {
			for (int j=0;j<i;j++) {
				
				if (allRotationInput[i].length < allRotationInput[j].length && allRotationInput[i].width < allRotationInput[j].width) {
					
					if (max_heights[j] + allRotationInput[i].height > max_heights[i]) {
						max_heights[i] = max_heights[j] + allRotationInput[i].height;
						result[i] = j;
					}
				}
			}
		}
		
        //find max in T[] and that will be our max height.
        //Result can also be found using result[] array.
        int max = Integer.MIN_VALUE;
        for(int i=0; i < max_heights.length; i++){
            if(max_heights[i] > max){
                max = max_heights[i];
            }
        }
		
        return max;
	}
	
	public static void createAllRotation(Dimension[] input, Dimension[] allRotationInput) {
		int index = 0;
		for (int i=0;i<input.length;i++) {
			allRotationInput[index++] = Dimension.createDimension(input[i].height, input[i].width, input[i].length);
			
			allRotationInput[index++] = Dimension.createDimension(input[i].length, input[i].height, input[i].width);
			
			allRotationInput[index++] = Dimension.createDimension(input[i].width, input[i].length, input[i].height);
		}
	}
	
	
	public static void main(String[] args) {
		Dimension input[] = { new Dimension(3, 2, 5), new Dimension(1, 2, 4) };
        int maxHeight = maxHeight(input);
        System.out.println("Max height is " + maxHeight);
        assert 11 == maxHeight;
	}
}

class Dimension implements Comparable<Dimension> {
	
	int height;
	int length;
	int width;

    Dimension(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    Dimension() {
    }
    
    static Dimension createDimension(int h, int side1, int side2) {
    	Dimension d = new Dimension();
    	d.height = h;
    	if(side1 >= side2) {
    		d.length = side1;
    		d.width = side2;
    	} else {
    		d.length = side2;
    		d.width = side1;
    	}
    	return d;
    }

    /* Sort by base area */
	public int compareTo(Dimension o) {
		if (this.length * this.width >= o.width * o.length)
			return -1;
		else 			
			return 1;
	}
	
	@Override
    public String toString() {
        return "Dimension [height=" + height + ", length=" + length
                + ", width=" + width + "]";
    }
	   
}
