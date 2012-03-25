import java.util.*;
import java.lang.String;

public class ContentRatio
{	
	//ratio for all content types
	public float text_ratio, video_ratio, image_ratio, link_ratio;
	
	public ContentRatio ()
	{
		text_ratio = 0;
		video_ratio = 0;
		image_ratio = 0;
		link_ratio = 0;
	}
	
	public void calc_content_ratio (Vector <Post> post_mass)
	{
		int text_count = 0, video_count = 0, image_num = 0, link_num = 0;
		if (post_mass.size() > 0) //if user have any contents (posts)
		{
			for (int i = 0; i < post_mass.size(); i++)
			{
				if (post_mass.elementAt(i).kind_content.equals("text")) // if content is a text
				{
					text_count++;
				}
				else
				{
					if (post_mass.elementAt(i).kind_content.equals("video")) // if content is an video
					{
						video_count++;
					}
					else
					{
						if (post_mass.elementAt(i).kind_content.equals("image")) // if content is an image
						{
							image_num++;
						}
						else // if content is a web-link
						{
							link_num++;
						}
					}
				}
			}
			
			//calculation of content ratio
			int content_number = text_count + video_count + image_num + link_num;
			//don't forgetting about integer devision!
			text_ratio = (float)((float)text_count / (float)content_number * 100.0);
			video_ratio = (float)(((float)video_count) / ((float)content_number) * 100);
			image_ratio = (float)(((float)image_num) / ((float)content_number) * 100);
			link_ratio = (float)(((float)link_num) / ((float)content_number) * 100);
		}
	}

	public static void main(String ar[])
	{
		Vector <Post> mass = new Vector<Post>();
		Post temp1 = new Post('t');
		mass.addElement(temp1);
		Post temp2 = new Post('t');
		mass.addElement(temp2);
		Post temp3 = new Post('i');
		mass.addElement(temp3);
		Post temp4 = new Post('v');
		mass.addElement(temp4);
		Post temp5 = new Post('l');
		mass.addElement(temp5);
		Post temp6 = new Post('l');
		mass.addElement(temp6);
		ContentRatio asd = new ContentRatio();
		asd.calc_content_ratio(mass);
		System.out.println(asd.text_ratio);
		System.out.println(asd.image_ratio);
		System.out.println(asd.link_ratio);
		System.out.println(asd.video_ratio);
	}
}
