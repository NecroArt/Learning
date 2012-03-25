
public class Post {

		/*public String actor_id;*/
		public String kind_content;
		/*public String content;
		public String original_content;
		public String published;
		public Vector <String> urls;
		public boolean kind_post;
		public short amount_urls;
		public short total_replies;
		public short total_plusoners;
		public short total_resharers;
		public short total_images;*/
		public Post (char type)
		{
			if (type == 't')
			{
				kind_content = "text";	
			}
			else
			{
				if (type == 'v')
				{
					kind_content = "video";
				}
				else
				{
					if (type == 'i')
					{
						kind_content = "image";
					}
					else
					{
						kind_content = "link";
					}
				}
			}				
		}
}
