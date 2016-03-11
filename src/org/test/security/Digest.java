
package org.test.security;

public class Digest {

    public static void main(String[] args)
    {
        String description = "This is the first write is time I write a program";
        String[] keywords = {
                "is", "write"
        };
        Digest digest = new Digest();
        System.out.println(digest.extractSummary(description, keywords));
    }

    public String extractSummary(String description, String[] keywords)
    {
        String result = new String();
        String segments[] = description.split(" ");
        // System.out.println(segments);
        int i = 0, j;
        int start = 0, final_start = 0, length = segments.length;
        boolean isStart = true, isEnd = false;
        int count[] = new int[keywords.length];
        while (i < segments.length)
        {
            for (j = 0; j < keywords.length; j++)
            {
                if (keywords[j].equals(segments[i]))
                {
                    count[j]++;
                    if (isStart)
                    {
                        start = i;
                        isStart = false;
                    }
                    else if (isAllExist(count))
                    {
                        isEnd = true;
                    }
                    break;
                }
            }

            if (isEnd)
            {
                if (i - start + 1 < length)
                {
                    length = i - start + 1;
                    final_start = start;

                }
                isStart = true;
                isEnd = false;
                for (int ii = 0; ii < count.length; ii++)
                {
                    count[ii] = 0;
                }
                i = start + 1;
            }
            else
            {
                i++;
            }
        }

        for (int k = 0; k < length; k++)
        {
            result += segments[final_start + k] + " ";
        }
        result.substring(0, result.length() - 2);
        return result;
    }

    public boolean isAllExist(int[] count)
    {
        boolean result = true;
        for (int temp : count)
        {
            if (temp == 0)
            {
                result = false;
                break;
            }
        }

        return result;
    }

}
