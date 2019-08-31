import axios from 'axios'
import youtube_config from '../youtube_config.json'

export async function getVideoInfo(videoId) {
  try {
    const response = await axios.get(
      `https://www.googleapis.com/youtube/v3/videos?key=${youtube_config.DEVELOPER_API_KEY}&part=statistics&id=${videoId}`,
    )
    return response.data
  } catch (error) {
    console.log(error)
    return null
  }
}
