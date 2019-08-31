import axios from 'axios'

export async function getVideoInfo(videoId) {
  try {
    const DEVELOPER_API_KEY = 'AIzaSyDXvqZm5r8DcUAz8DcPt8c0_pCZmQ3_0BE'
    const response = await axios.get(
      `https://www.googleapis.com/youtube/v3/videos?key=${DEVELOPER_API_KEY}&part=statistics&id=${videoId}`,
    )
    return response.data
  } catch (error) {
    console.log(error)
    return null
  }
}
