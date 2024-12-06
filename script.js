function calculateTimeElapsed() {
    const startDate = new Date('2007-01-15T00:00:00');
    const now = new Date();
    const diff = now - startDate;

    const days = Math.floor(diff / (1000 * 60 * 60 * 24));
    const hours = Math.floor((diff / (1000 * 60 * 60)) % 24);
    const minutes = Math.floor((diff / (1000 * 60)) % 60);
    const seconds = Math.floor((diff / 1000) % 60);

    return `${days} days, ${hours} hours, ${minutes} minutes, ${seconds} seconds`;
}

function updateElapsedTime() {
    const timeElement = document.getElementById('timeElapsed');
    timeElement.textContent = calculateTimeElapsed();
}

setInterval(updateElapsedTime, 1000);
updateElapsedTime();
