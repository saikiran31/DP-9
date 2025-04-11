class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) ->{
            if(a[0]==b[0])
            {
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int arr[] = new int[n];
        arr[0] = envelopes[0][1];
        int le =1;
        for(int i=1;i<n;i++)
        {
            if(arr[le-1] < envelopes[i][1])
            {
                arr[le] = envelopes[i][1];
                le++;
            }
            else{
                int bsIdx = binarysearch(arr,0,le-1,envelopes[i][1]);
                arr[bsIdx] = envelopes[i][1];
            }
        }
        return le;
    }
private int binarysearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}

//tc: O(n log n)
//sc: O(n)