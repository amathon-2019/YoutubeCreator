import axios from 'axios'
import youtube_config from '../youtube_config.json'

export async function getThumbnail(authorId) {
  try {
    const response = await axios.get(
      `https://www.googleapis.com/youtube/v3/channels?part=snippet&fields=items%2Fsnippet%2Fthumbnails%2Fdefault&id=${authorId}&key=${youtube_config.DEVELOPER_API_KEY}`,
    )
    return response.data.items[0].snippet.thumbnails.default.url
  } catch (error) {
    console.log(error)
    return null
  }
}
